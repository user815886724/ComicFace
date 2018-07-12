package com.Face.dao;

import com.Face.model.TestData;

import java.util.List;

public interface TestDataDao {

    int insertTestData(TestData data);

    List<TestData> selectAllTestData();
}
