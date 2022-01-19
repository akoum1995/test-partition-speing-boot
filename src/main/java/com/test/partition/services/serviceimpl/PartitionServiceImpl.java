package com.test.partition.services.serviceimpl;


import com.test.partition.services.ParitionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class PartitionServiceImpl implements ParitionService {
    @Override
    public List<List<Integer>> getPartitionResult(List<Integer> initialArray, Integer lengthPartition) throws Exception {
        if(lengthPartition <= 0) {
            throw new Exception("Please enter a valid number : minimum 1");
        }
        AtomicInteger index = new AtomicInteger(1);
        List<List<Integer>> result = new ArrayList<>();
        final List<Integer>[] partition = new List[]{new ArrayList<>()};
        initialArray.forEach(integer -> {
            if(index.get() != 0 && index.get() % lengthPartition == 0) {
                partition[0].add(integer);
                result.add(partition[0]);
                partition[0] = new ArrayList<>();
                index.getAndIncrement();
            } else {
                partition[0].add(integer);
                if(index.get() == initialArray.size() && partition[0].size() != 0) {
                    result.add(partition[0]);
                } else {
                    index.getAndIncrement();
                }
            }

        });
        return result;
    }
}
