
interface Bookable {

    Token bookToken(int patientId, int doctorId)
            throws HospitalException;

    void cancelToken(int tokenNumber)
            throws HospitalException;

}
