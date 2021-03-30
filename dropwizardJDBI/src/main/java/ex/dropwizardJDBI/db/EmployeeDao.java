package ex.dropwizardJDBI.db;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import ex.dropwizardJDBI.api.Employee;

@RegisterMapper(EmployeeMapper.class)
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
