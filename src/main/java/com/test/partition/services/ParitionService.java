package com.test.partition.services;

import java.util.List;

public interface ParitionService {


    public List<List<Integer>> getPartitionResult(List<Integer> initialArray, Integer lengthPartition) throws Exception;
}
