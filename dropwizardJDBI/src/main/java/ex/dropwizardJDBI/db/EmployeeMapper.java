package ex.dropwizardJDBI.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import ex.dropwizardJDBI.api.Employee;

public class EmployeeMapper implements ResultSetMapper<Employee>{

	@Override
	public Employee map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		// TODO Auto-generated method stub
		Employee employee =new Employee(r.getInt(1), r.getString(2), r.getString(3));
		return employee;
	}

}
