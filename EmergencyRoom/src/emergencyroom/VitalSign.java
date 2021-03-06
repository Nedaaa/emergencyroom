package emergencyroom;

import java.io.Serializable;

public class VitalSign implements Serializable{
	
	//Auto-generated by Eclipse
	private static final long serialVersionUID = -2654530584537496028L;
	// the temperature of the recorded vital sign
	private double temperature;
	// the systolic blood pressure reading of the recorded vital sign
	private int systolic;
	// the diastolic blood pressure reading of the recorded vital sign
	private int diastolic;
	// the heart rate reading of the recorded vital sign
	private int heartRate;
	
	/**
	 * Creates a new record for the vital signs of a Patient given their
	 * temperature, systolic blood pressure, diastolic blood pressure and
	 * heart rate
	 * @param temp the temperature of the new VitalSign
	 * @param systolic the systolic blood pressure of the new VitalSign
	 * @param diastolic the diastolic blood pressure of the new VitalSign
	 * @param heartRate the heart rate of the new VitalSign
	 */
	public VitalSign(double temp, int systolic, int diastolic, int heartRate){
		this.temperature = temp;
		this.systolic = systolic;
		this.diastolic = diastolic;
		this.heartRate = heartRate;
	}

	/**
	 * Returns the temperature of this VitalSign, which is associated to
	 * a Patient
	 * @return temperature the temperature of this VitalSign
	 */
	public double getTemperature() {
		return temperature;
	}

	/**
	 * Sets the temperature of this VitalSign,
	 * which is associated to a Patient, to temperature
	 * @param temperature the temperature of this VitalSign
	 */
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	/**
	 * Returns the systolic blood pressure of this VitalSign, which is
	 * associated to a Patient
	 * @return systolic the systolic blood pressure of this VitalSign
	 */
	public int getSystolic() {
		return systolic;
	}

	/**
	 * Sets the systolic blood pressure of this VitalSign, which is associated
	 * to a Patient, to systolic
	 * @param systolic the systolic blood pressure of this VitalSign
	 */
	public void setSystolic(int systolic) {
		this.systolic = systolic;
	}

	/**
	 * Returns the diastolic blood pressure of this VitalSign, which is 
	 * associated to a Patient
	 * @return diastolic the diastolic blood pressure of this VitalSign
	 */
	public int getDiastolic() {
		return diastolic;
	}

	/**
	 * Sets the diastolic blood pressure of this VitalSign, which is 
	 * associated to a Patient, to diastolic
	 * @param diastolic the diastolic blood pressure of this VitalSign
	 */
	public void setDiastolic(int diastolic) {
		this.diastolic = diastolic;
	}

	/**
	 * Returns the heart rate of this VitalSign, which is associated to a 
	 * Patient
	 * @return heartRate the heart rate of this VitalSign
	 */
	public int getHeartRate() {
		return heartRate;
	}

	/**
	 * Sets the heart rate of this VitalSign, which is associated with a
	 * Patient, to heartRate
	 * @param heartRate the heart rate of this VitalSign
	 */
	public void setHeartRate(int heartRate) {
		this.heartRate = heartRate;
	}
	
	/**
	 * Returns a String representation of a VitalSign
	 * @return result the string representation of VitalSign
	 */
	public String toString(){
		String result = temperature + "~" + systolic + "~" + diastolic + "~"
				+ heartRate;
		return result;
	}
}
