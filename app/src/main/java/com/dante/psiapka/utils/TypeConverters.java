package com.dante.psiapka.utils;

import androidx.room.TypeConverter;

import com.dante.psiapka.model.Gender;

import java.util.Date;

public class TypeConverters {

    @TypeConverter
    public String fromGender(Enum<Gender> genderEnum) {
        return genderEnum.toString();
    }

    @TypeConverter
    public Enum<Gender> toGender(String gender) {
        return Gender.valueOf(gender);
    }

    @TypeConverter
    public Date toDate(Long longDate) {
        return new Date(longDate);
    }

    @TypeConverter
    public Long fromDate(Date date) {
        return date.getTime();
    }
}
