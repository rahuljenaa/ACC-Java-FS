package com.accenture.ltt.dao;

import java.util.ArrayList;
import java.util.List;

import com.accenture.ltt.businessbean.EmployeeBean;
import com.accenture.ltt.utility.DBUtility;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

import org.bson.Document;

public class EmployeeDAOImpl implements EmployeeDAO {

    private MongoCollection<Document> collection;

    public EmployeeDAOImpl() {
        MongoDatabase database = DBUtility.getDBConnection();
        collection = database.getCollection("employees");
    }

   
    @Override
    public int insertEmployee(EmployeeBean bean) {
        collection.insertOne(convertToDocument(bean));
        return 1; // Success
    }

    @Override
    public List<EmployeeBean> readEmployee() {
        List<EmployeeBean> list = new ArrayList<>();
        for (Document doc : collection.find()) {
            list.add(convertToBean(doc));
        }
        return list;
    }

    @Override
    public void updateEmployee(EmployeeBean bean) {
        // Only update fields that are not null
        List<org.bson.conversions.Bson> updates = new ArrayList<>();

        if (bean.getEmployeeName() != null) {
            updates.add(Updates.set("employeeName", bean.getEmployeeName()));
        }
        if (bean.getRole() != null) {
            updates.add(Updates.set("role", bean.getRole()));
        }
        if (bean.getSalary() != null) {
            updates.add(Updates.set("salary", bean.getSalary()));
        }

        if (!updates.isEmpty()) {
            collection.updateOne(Filters.eq("employeeID", bean.getEmployeeID()),
                    Updates.combine(updates));
        }
    }

    @Override
    public void deleteEmployee(EmployeeBean bean) {
        collection.deleteOne(Filters.eq("employeeID", bean.getEmployeeID()));
    }
    
    // Convert EmployeeBean → MongoDB Document
    private Document convertToDocument(EmployeeBean emp) {
        Document doc = new Document("employeeID", emp.getEmployeeID())
                .append("employeeName", emp.getEmployeeName())
                .append("role", emp.getRole())
                .append("salary", emp.getSalary())
                .append("insertTime", emp.getInsertTime());
        return doc;
    }

    // Convert MongoDB Document → EmployeeBean
    private EmployeeBean convertToBean(Document doc) {
        EmployeeBean emp = new EmployeeBean();
        emp.setEmployeeID(doc.getInteger("employeeID"));
        emp.setEmployeeName(doc.getString("employeeName"));
        emp.setRole(doc.getString("role"));
        emp.setSalary(doc.getDouble("salary"));
        emp.setInsertTime(doc.getDate("insertTime"));
        return emp;
    }

}
