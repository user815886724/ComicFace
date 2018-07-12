package com.Face.controller;

import com.Face.common.ServiceResponse;
import com.Face.model.TestData;
import com.Face.service.ITestDataService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("TestData")
public class TestDataController {

    @Autowired
    private ITestDataService iTestDataService;

    @RequestMapping("getAllTestData")
    @ResponseBody
    public ServiceResponse<PageInfo> getAllTestData(@RequestParam(value = "pageNum",defaultValue = "1")int pageNum, @RequestParam(value ="pageSize",defaultValue="10")int pageSize){
        return ServiceResponse.createBySuccess(iTestDataService.selectAllTestData(pageNum,pageSize));
    }

    @RequestMapping("insertTestData")
    @ResponseBody
    public ServiceResponse insertTestData(TestData testData){
        if(iTestDataService.insertTestData(testData) > 0){
            return ServiceResponse.createBySuccess();
        }
        return ServiceResponse.createByError();
    }
}
