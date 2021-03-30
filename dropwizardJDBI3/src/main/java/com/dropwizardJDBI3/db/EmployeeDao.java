package com.dropwizardJDBI3.db;

import java.util.List;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import com.dropwizardJDBI3.api.Employee;

@RegisterRowMapper(EmployeeMapper.class)
public interface EmployeeDao {
	@SqlQuery("select * from employee3")
	public List<Employee> getEmployees();

	@SqlQuery("select * from employee3 where id = :id")
	public Employee getEmployee(@Bind("id") final int id);

	@SqlUpdate("insert into employee3(id, name, salary) values(:id,:name,:salary)")
	void createEmployee(@BindBean final Employee employee);

	@SqlUpdate("update employee3 set name = coalesce(:name, name), "
			+ "salary = coalesce(:salary, salary)" + " where id = :id")
	void editEmployee(@BindBean final Employee employee);

	@SqlUpdate("delete from employee3 where id = :id")
	int deleteEmployee(@Bind("id") final int id);

}
