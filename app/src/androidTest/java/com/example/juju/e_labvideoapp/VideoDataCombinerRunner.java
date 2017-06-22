package com.example.juju.e_labvideoapp;

import com.example.juju.e_labvideoapp.VideoDataCombiner;

public class VideoDataCombinerRunner {

    public static void main(String[] args) {
        VideoDataCombiner combiner = new VideoDataCombiner();
        combiner.CombineAndCreate("Tools/frame-extractor/TestData/2017-06-22_100608.mp4",
                "Tools/frame-extractor/TestData/2017-06-22_100608.csv");

        System.out.println("Finished");
    }

}