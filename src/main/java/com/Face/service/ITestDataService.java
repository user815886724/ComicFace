package com.Face.service;

import com.Face.model.TestData;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ITestDataService {
    public int insertTestData(TestData testData);

    public PageInfo selectAllTestData(int pageNum, int pageSize);
}
