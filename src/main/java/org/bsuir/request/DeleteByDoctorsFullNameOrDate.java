package org.bsuir.request;

import org.bsuir.util.CustomDate;
import org.bsuir.util.RequestType;

public class DeleteByDoctorsFullNameOrDate extends ServerRequest{
    private CustomDate birthday;
    private String doctorsFullName;

    public DeleteByDoctorsFullNameOrDate(String doctorsFullName,CustomDate birthday) {
        this.birthday = birthday;
        this.doctorsFullName = doctorsFullName;
        this.requestType = RequestType.DELETE_BY_DOCTORS_NAME_OR_DATE;
    }

    public DeleteByDoctorsFullNameOrDate(){
        super();
    }

    public CustomDate getBirthday() {
        return birthday;
    }

    public String getDoctorsFullName() {
        return doctorsFullName;
    }
}
