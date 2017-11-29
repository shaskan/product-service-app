package com.accn.ppes.magellan;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.accn.ppes.magellan.ProductApplication;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=ProductApplication.class)
@WebAppConfiguration
public abstract class AbstractTest {


}
