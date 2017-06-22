package com.example.juju.e_labvideoapp;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

import android.media.MediaRecorder;
import android.media.MediaMetadataRetriever;
import android.graphics.Bitmap;

/**
 * Created by Fafa on 2017-06-22.
 */
public class VideoDataCombiner {

    private void WriteDataFile(String path, String header, String data)
            throws IOException
    {
        PrintStream fw = new PrintStream (path);
        fw.println(header);
        fw.println(data);
        fw.close();
    }

    private void WriteImageFile(String path, Bitmap image)
            throws IOException
    {
        FileOutputStream fOut = new FileOutputStream(path);
        image.compress(Bitmap.CompressFormat.JPEG, 95, fOut);
        fOut.flush();
        fOut.close();
    }

    private int GetMilisecondsFromLine(String line)
    {
        String[] tokens = line.split(",");
        return GetMiliseconds(tokens[4]);
    }

    private int GetMiliseconds(String data)
    {
        String[] tokens = data.split(":");
        Double seconds = (((Integer.parseInt(tokens[0]) * 60)
                + Integer.parseInt(tokens[1])) * 60)
                + Integer.parseInt(tokens[2])
                + Integer.parseInt(tokens[3]) / 1000.0;
        return (int)(seconds * 1000);
    }

    public void CombineAndCreate(String videoPath, String dataPath)
    {
        File file = new File(dataPath);
        MediaMetadataRetriever retriever = new MediaMetadataRetriever();
        //Long duration = Long.parseLong(mediaMetadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION));
        Bitmap image;

        int frameNumber = 1;
        try {
            retriever.setDataSource(videoPath);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String header = bufferedReader.readLine();
            String firstLine = bufferedReader.readLine();
            int startMiliseconds = GetMilisecondsFromLine(firstLine);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // create file with header and data line
                String framePath = dataPath.replaceFirst(".csv", "_" + frameNumber + ".jpg");
                String frameDataPath = dataPath.replaceFirst(".csv", "_" + frameNumber + ".txt");

                int currentMiliseconds = GetMilisecondsFromLine(line);
                int elapsedMiliseconds = currentMiliseconds - startMiliseconds;
                image = retriever.getFrameAtTime(elapsedMiliseconds * 1000, MediaMetadataRetriever.OPTION_CLOSEST);

                WriteImageFile(framePath, image);
                WriteDataFile(frameDataPath, header, line);
                frameNumber++;
            }
            fileReader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        } catch (RuntimeException ex) {
            ex.printStackTrace();
        } finally {
            try {
                retriever.release();
            } catch (RuntimeException ex) {
            }
        }

    }


}
