package curso.java.hibernate.data.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "TBL_TASK")
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "task_name")
    private String taskName;

    @Column(name = "task_description")
    private String taskDescription;

    @Column(name = "employee_id")
    private Integer employeeId;

    @ManyToOne
    @JoinColumn(name = "scope_id", referencedColumnName = "id")
    private Scope scope;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getTaskName() { return taskName; }
    public void setTaskName(String taskName) { this.taskName = taskName; }

    public String getTaskDescription() { return taskDescription; }
    public void setTaskDescription(String taskDescription) { this.taskDescription = taskDescription; }

    public Integer getEmployeeId() { return employeeId; }
    public void setEmployeeId(Integer employeeId) { this.employeeId = employeeId; }

    public Scope getScope() { return scope; }
    public void setScope(Scope scope) { this.scope = scope; }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", taskName='" + taskName + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                '}';
    }
}