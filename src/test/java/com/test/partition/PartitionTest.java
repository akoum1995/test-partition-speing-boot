package com.test.partition;


import com.test.partition.services.serviceimpl.PartitionServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PartitionTest {
    @InjectMocks
    PartitionServiceImpl partitionService;

    @Test
    public void testNumberOne() throws Exception {
        List<Integer> exampleOne = Arrays.asList(1, 2, 3, 4, 5);
        List<List<Integer>> result = partitionService.getPartitionResult(exampleOne, 2);
        List<List<Integer>> resultShouldBe = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4), Collections.singletonList(5));
        Assertions.assertEquals(result, resultShouldBe);
    }
    @Test
    public void testNumberTwo() throws Exception {
        List<Integer> exampleOne = Arrays.asList(1, 2, 3, 4, 5);
        List<List<Integer>> result = partitionService.getPartitionResult(exampleOne, 3);
        List<List<Integer>> resultShouldBe = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5));
        Assertions.assertEquals(result, resultShouldBe);
    }
    @Test
    public void testNumberTree() throws Exception {
        List<Integer> exampleOne = Arrays.asList(1, 2, 3, 4, 5);
        List<List<Integer>> result = partitionService.getPartitionResult(exampleOne, 1);
        List<List<Integer>> resultShouldBe = Arrays.asList(Collections.singletonList(1), Collections.singletonList(2), Collections.singletonList(3), Collections.singletonList(4), Collections.singletonList(5));
        Assertions.assertEquals(result, resultShouldBe);
    }
    @Test
    public void testNumberFour() throws Exception {
        List<Integer> exampleOne = Arrays.asList(1, 2, 3, 4, 5);
        List<List<Integer>> result = partitionService.getPartitionResult(exampleOne, 4);
        List<List<Integer>> resultShouldBe = Arrays.asList(Arrays.asList(1, 2, 3, 4), Collections.singletonList(5));
        Assertions.assertEquals(result, resultShouldBe);
    }
    @Test
    public void testNumberFive() throws Exception {
        List<Integer> exampleOne = Arrays.asList(1, 2, 3, 4, 5);
        List<List<Integer>> result = partitionService.getPartitionResult(exampleOne, 5);
        List<List<Integer>> resultShouldBe = Collections.singletonList(Arrays.asList(1, 2, 3, 4, 5));
        Assertions.assertEquals(result, resultShouldBe);
    }
    @Test
    public void testNumberSix() throws Exception {
        List<Integer> exampleOne = Arrays.asList(1, 2, 3, 4, 5);
        List<List<Integer>> result = partitionService.getPartitionResult(exampleOne, 6);
        List<List<Integer>> resultShouldBe = Collections.singletonList(Arrays.asList(1, 2, 3, 4, 5));
        Assertions.assertEquals(result, resultShouldBe);
    }
    @Test
    public void testNumberZero() throws Exception {
        List<Integer> exampleOne = Arrays.asList(1, 2, 3, 4, 5);
        Exception exception = Assertions.assertThrows(Exception.class, () -> {partitionService.getPartitionResult(exampleOne, 0);} );
        String expectedMessage = "Please enter a valid number : minimum 1";
        Assertions.assertEquals(expectedMessage, exception.getMessage());
    }
}
