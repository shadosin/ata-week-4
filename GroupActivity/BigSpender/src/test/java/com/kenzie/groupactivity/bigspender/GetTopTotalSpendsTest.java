package com.kenzie.groupactivity.bigspender;

import com.kenzie.groupactivity.bigspender.dao.AwsServiceInvoiceDao;
import com.kenzie.groupactivity.bigspender.types.CustomerServiceSpend;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class GetTopTotalSpendsTest {
    private AwsCustomerStatistics customerStatistics;

    private AwsServiceInvoiceDao dao = new AwsServiceInvoiceDao();

    @BeforeEach
    public void setup() {
        customerStatistics = new AwsCustomerStatistics(dao);
    }

    @Test
    public void getTopTotalSpends_get_spendsAreSortedByName() {
        // WHEN
        List<CustomerServiceSpend> result = customerStatistics.getTopServiceSpendForEachCustomer();

        // THEN
        // CustomerServiceSpends are ordered by customer name, ascending
        // backup
        try {
            CustomerServiceSpend firstResult = result.get(0);
            assertEquals(dao.getCustomerData().get("backup"), firstResult.getCustomer());
            assertEquals(dao.getCharges().get("backup").get(0), firstResult.getServiceSpend());

            // godiddy
            CustomerServiceSpend secondResult = result.get(1);
            assertEquals(dao.getCustomerData().get("godiddy"), secondResult.getCustomer());
            assertEquals(dao.getCharges().get("godiddy").get(0), secondResult.getServiceSpend());

            // nedflix
            CustomerServiceSpend thirdResult = result.get(2);
            assertEquals(dao.getCustomerData().get("nedflix"), thirdResult.getCustomer());
            assertEquals(dao.getCharges().get("nedflix").get(0), thirdResult.getServiceSpend());
        } catch(NullPointerException e) {
            fail("getTopServiceSpendForEachCustomer() not implemented");
        }
    }
}
