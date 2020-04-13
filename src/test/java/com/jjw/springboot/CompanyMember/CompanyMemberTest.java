package com.jjw.springboot.CompanyMember;

import com.jjw.springboot.SpringbootApplication;
import com.jjw.springboot.component.CountScoreTask;
import com.jjw.springboot.service.CompanyMemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = {SpringbootApplication.class})
@RunWith(SpringRunner.class)
public class CompanyMemberTest {

    @Autowired
    private CompanyMemberService companyMemberService;

    @Test
    public void countScoreTest() {
        CountScoreTask countScoreTask = new CountScoreTask();
        countScoreTask.coutScore();
    }
}
