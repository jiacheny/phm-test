/**
 * Created by UC196987 Jiachen Yan on 3/19/2019
 */

public class Task {

  private long taskId;
  private String name;
  private double duration;
  private String personnelType; // if type is certain, enum can also be used for this variable
  private double hourlyRate;
  private int numberOfPersonnel;

  public Task(long taskId, String name, double duration, String personnelType, double hourlyRate, int numberOfPersonnel) {
    this.taskId = taskId;
    this.name = name;
    this.duration = duration;
    this.personnelType = personnelType;
    this.hourlyRate = hourlyRate;
    this.numberOfPersonnel = numberOfPersonnel;
  }

  public long getTaskId() {
    return taskId;
  }

  public void setTaskId(long taskId) {
    this.taskId = taskId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getDuration() {
    return duration;
  }

  public void setDuration(double duration) {
    this.duration = duration;
  }

  public String getPersonnelType() {
    return personnelType;
  }

  public void setPersonnelType(String personnelType) {
    this.personnelType = personnelType;
  }

  public double getHourlyRate() {
    return hourlyRate;
  }

  public void setHourlyRate(double hourlyRate) {
    this.hourlyRate = hourlyRate;
  }

  public int getNumberOfPersonnel() {
    return numberOfPersonnel;
  }

  public void setNumberOfPersonnel(int numberOfPersonnel) {
    this.numberOfPersonnel = numberOfPersonnel;
  }
}
