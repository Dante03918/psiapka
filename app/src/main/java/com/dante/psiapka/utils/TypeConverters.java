package com.dante.psiapka.utils;

import androidx.room.TypeConverter;

import com.dante.psiapka.model.Gender;

import java.util.Date;

public class TypeConverters {

    @TypeConverter
    public String fromGender(Enum<Gender> genderEnum) {

        return genderEnum == null ? "" : genderEnum.toString();

    }

    @TypeConverter
    public Enum<Gender> toGender(String gender) {

        return gender.equals("")  ? Gender.UNKNOWN : Gender.valueOf(gender);
    }

    @TypeConverter
    public Date toDate(Long longDate) {

        return longDate == null ? new Date(System.currentTimeMillis()) : new Date(longDate);
    }

    @TypeConverter
    public Long fromDate(Date date) {

        return date == null ? 0L : date.getTime();
    }
}
