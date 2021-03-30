package com.dropwizardJDBI3.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import com.dropwizardJDBI3.api.Employee;

public class EmployeeMapper implements RowMapper<Employee>{

	@Override
	public Employee map(ResultSet rs, StatementContext ctx) throws SQLException {
		Employee employee =new Employee(rs.getInt(1), rs.getString(2), rs.getString(3));
		return employee;
	}

}
