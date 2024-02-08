package curso.java.hibernate;

import curso.java.hibernate.data.EmployeeRepository;
import curso.java.hibernate.data.ScopeRepository;
import curso.java.hibernate.data.entity.Employee;
import curso.java.hibernate.data.entity.Scope;
import curso.java.hibernate.data.entity.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@SpringBootApplication
@EnableJpaAuditing
public class HibernateExampleApp implements CommandLineRunner {

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  EmployeeRepository repositoryEmp;
  @Autowired
  ScopeRepository repositoryScp;

  public static void main(String[] args) {
    SpringApplication.run(HibernateExampleApp.class, args);
  }

  @Override
  public void run(String... args) throws Exception
  {
    Employee emp2 = new Employee();
    emp2.setEmail("new Employee email");
    emp2.setFirstName("Bart");
    emp2.setLastName("Simpson");

    emp2.setTasks(getTasks());

    repositoryEmp.save(emp2);
    Optional<Employee> emp = repositoryEmp.findById(2L);
    emp.ifPresent(employee -> logger.info("Employee id 2 -> {}", emp.get()));

    repositoryEmp.findAll().forEach(System.out::println);

    Scope scp3 = new Scope();
    scp3.setName("Paco");
    scp3.setDescription("Finanzas");

    scp3.setTasks(getTasks());

    repositoryScp.save(scp3);
    Optional<Scope> scp = repositoryScp.findById(3L);
    scp.ifPresent(scope -> logger.info("Scope id 3 -> {}", scp.get()));

    repositoryScp.findAll().forEach(System.out::println);
  }

  private Set<Task> getTasks() {

    Set<Task> tasks = new HashSet<>();
    Task task1 = new Task();
    task1.setTaskName("report generation");
    task1.setTaskDescription("Daily report generation");
    tasks.add(task1);
    Task task2 = new Task();
    task2.setTaskName("view generation");
    task2.setTaskDescription("Daily view generation");
    tasks.add(task2);
    return tasks;
  }
}
