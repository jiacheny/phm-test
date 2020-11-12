import java.util.List;

/**
 * Created by UC196987 Jiachen Yan on 3/19/2019
 */

public class MaintenanceAction {

  private long actionID;
  private String name;
  private MaintenanceType maintenanceType;
  private double MTBMInHours;
  private List<Task> tasks;

  public MaintenanceAction(long actionID, String name, MaintenanceType maintenanceType, double MTBMInHours, List<Task> tasks) {
    this.actionID = actionID;
    this.name = name;
    this.maintenanceType = maintenanceType;
    this.MTBMInHours = MTBMInHours;
    setTasks(tasks);
  }

  public void setTasks(List<Task> tasks) {
    if (tasks == null || tasks.size() == 0)
      throw new IllegalArgumentException("At least one task is required for the maintenance action.");
    this.tasks = tasks;
  }

  public List<Task> getTasks() {
    return tasks;
  }

  public long getActionID() {
    return actionID;
  }

  public void setActionID(long actionID) {
    this.actionID = actionID;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public MaintenanceType getMaintenanceType() {
    return maintenanceType;
  }

  public void setMaintenanceType(MaintenanceType maintenanceType) {
    this.maintenanceType = maintenanceType;
  }

  public double getMTBMInHours() {
    return MTBMInHours;
  }

  public void setMTBMInHours(double MTBMInHours) {
    this.MTBMInHours = MTBMInHours;
  }

}
