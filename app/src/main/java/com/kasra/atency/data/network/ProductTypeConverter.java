package com.kasra.atency.data.network;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kasra.atency.data.model.Address;
import com.kasra.atency.data.model.performance.day.AttendanceType;
import com.kasra.atency.data.model.performance.day.Code;
import com.kasra.atency.data.model.request.RequestClass;
import com.kasra.atency.data.model.request.RequestGroup;
import com.kasra.atency.data.model.workperiod.Workperiod;
import com.kasra.atency.data.model.workplace.Brand;
import com.kasra.atency.data.model.workplace.Country;
import com.kasra.atency.data.model.workplace.Recorder;
import com.kasra.atency.data.model.workplace.State;
import com.kasra.atency.data.model.workplace.TimeZone;
import com.kasra.atency.data.model.workplace.WorkplaceModel;

import java.lang.reflect.Type;
import java.util.List;

public class ProductTypeConverter {

    //Address Converter
    @TypeConverter
    public static Address PalceArrayListToJson(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<Address>() {
        }.getType();
        Address measurements = gson.fromJson(json, type);
        return measurements;
    }

    @TypeConverter
    public static String PlaceJsonToArrayList(Address address) {
        Gson gson = new Gson();
        Type type = new TypeToken<Address>() {
        }.getType();
        String json = gson.toJson(address, type);
        return json;
    }

    //Object Converter
    @TypeConverter
    public static Object ObjectToString(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<Object>() {
        }.getType();
        Object measurements = gson.fromJson(json, type);
        return measurements;
    }

    @TypeConverter
    public static String StringToObject(Object object) {
        Gson gson = new Gson();
        Type type = new TypeToken<Object>() {
        }.getType();
        String json = gson.toJson(object, type);
        return json;
    }

    //Country Converter
    @TypeConverter
    public static Country CountryToString(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<Country>() {
        }.getType();
        Country measurements = gson.fromJson(json, type);
        return measurements;
    }

    @TypeConverter
    public static String StringToCountry(Country object) {
        Gson gson = new Gson();
        Type type = new TypeToken<Country>() {
        }.getType();
        String json = gson.toJson(object, type);
        return json;
    }

    //State Converter
    @TypeConverter
    public static State StateToString(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<State>() {
        }.getType();
        State measurements = gson.fromJson(json, type);
        return measurements;
    }

    @TypeConverter
    public static String StringToState(State object) {
        Gson gson = new Gson();
        Type type = new TypeToken<State>() {
        }.getType();
        String json = gson.toJson(object, type);
        return json;
    }

    //List<Recorder> Converter
    @TypeConverter
    public static List<Recorder> ListRecorderToString(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<Recorder>>() {
        }.getType();
        List<Recorder> measurements = gson.fromJson(json, type);
        return measurements;
    }

    @TypeConverter
    public static String StringToListRecorder(List<Recorder> object) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<Recorder>>() {
        }.getType();
        String json = gson.toJson(object, type);
        return json;
    }

    //Recorder Converter
    @TypeConverter
    public static Recorder RecorderToString(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<Recorder>() {
        }.getType();
        Recorder measurements = gson.fromJson(json, type);
        return measurements;
    }

    @TypeConverter
    public static String StringToRecorder(Recorder object) {
        Gson gson = new Gson();
        Type type = new TypeToken<Recorder>() {
        }.getType();
        String json = gson.toJson(object, type);
        return json;
    }

    //Type Converter
    @TypeConverter
    public static Type TypeToString(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<Type>() {
        }.getType();
        Type measurements = gson.fromJson(json, type);
        return measurements;
    }

    @TypeConverter
    public static String StringToType(Type object) {
        Gson gson = new Gson();
        Type type = new TypeToken<Type>() {
        }.getType();
        String json = gson.toJson(object, type);
        return json;
    }

    //Brand Converter
    @TypeConverter
    public static Brand BrandToString(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<Brand>() {
        }.getType();
        Brand measurements = gson.fromJson(json, type);
        return measurements;
    }

    @TypeConverter
    public static String StringToBrand(Brand object) {
        Gson gson = new Gson();
        Type type = new TypeToken<Brand>() {
        }.getType();
        String json = gson.toJson(object, type);
        return json;
    }

    //AttendanceType Converter
    @TypeConverter
    public static AttendanceType AttendanceTypeToString(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<AttendanceType>() {
        }.getType();
        AttendanceType measurements = gson.fromJson(json, type);
        return measurements;
    }

    @TypeConverter
    public static String StringToAttendanceType(AttendanceType object) {
        Gson gson = new Gson();
        Type type = new TypeToken<AttendanceType>() {
        }.getType();
        String json = gson.toJson(object, type);
        return json;
    }

    @TypeConverter
    public static List<Workperiod> jsonToWorkPeriods(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<Workperiod>>() {
        }.getType();
        List<Workperiod> measurements = gson.fromJson(json, type);
        return measurements;
    }

    @TypeConverter
    public static List<WorkplaceModel> jsonToWorkPlaces(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<WorkplaceModel>>() {
        }.getType();
        List<WorkplaceModel> measurements = gson.fromJson(json, type);
        return measurements;
    }
    @TypeConverter
    public static String workPlaceToJson(List<WorkplaceModel> workplaceModelList) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<WorkplaceModel>>() {
        }.getType();
        String measurements = gson.toJson(type);
        return measurements;
    }
    @TypeConverter
    public static String workPeriodJsonToArrayList(List<Workperiod> workperiods) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<Workperiod>>() {
        }.getType();
        String json = gson.toJson(workperiods, type);
        return json;
    }

    @TypeConverter
    public static Workperiod jsontoWorkPeriod(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<Workperiod>() {
        }.getType();
        Workperiod measurements = gson.fromJson(json, type);
        return measurements;
    }

    @TypeConverter
    public static WorkplaceModel jsontoWorkPlace(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<WorkplaceModel>() {
        }.getType();
        WorkplaceModel measurements = gson.fromJson(json, type);
        return measurements;
    }

    @TypeConverter
    public static String WorkPlacetiJson(WorkplaceModel workplaceModel) {
        Gson gson = new Gson();
        Type type = new TypeToken<WorkplaceModel>() {
        }.getType();
        String measurements = gson.toJson(workplaceModel);
        return measurements;
    }

    @TypeConverter
    public static String workperiodJsonToJson(Workperiod workperiod) {
        Gson gson = new Gson();
        Type type = new TypeToken<Workperiod>() {
        }.getType();
        String json = gson.toJson(workperiod, type);
        return json;
    }

    @TypeConverter
    public static Code CodeToJson(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<Code>() {
        }.getType();
        Code measurements = gson.fromJson(json, type);
        return measurements;
    }

    @TypeConverter
    public static String CodeJsonToArrayList(Code list) {
        Gson gson = new Gson();
        Type type = new TypeToken<Code>() {
        }.getType();
        String json = gson.toJson(list, type);
        return json;
    }

    @TypeConverter
    public static RequestClass RequestClassToJson(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<RequestClass>() {
        }.getType();
        RequestClass measurements = gson.fromJson(json, type);
        return measurements;
    }

    @TypeConverter
    public static String RequestClassJsonToArrayList(RequestClass list) {
        Gson gson = new Gson();
        Type type = new TypeToken<RequestClass>() {
        }.getType();
        String json = gson.toJson(list, type);
        return json;
    }
    @TypeConverter
    public static TimeZone TimeZoneToJson(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<TimeZone>() {
        }.getType();
        TimeZone measurements = gson.fromJson(json, type);
        return measurements;
    }

    @TypeConverter
    public static String TimeZoneJsonToArrayList(TimeZone list) {
        Gson gson = new Gson();
        Type type = new TypeToken<TimeZone>() {
        }.getType();
        String json = gson.toJson(list, type);
        return json;
    }

    @TypeConverter
    public static RequestGroup RequestGroupClassToJson(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<RequestGroup>() {
        }.getType();
        RequestGroup measurements = gson.fromJson(json, type);
        return measurements;
    }

    @TypeConverter
    public static String RequestGroupClassJsonToArrayList(RequestGroup list) {
        Gson gson = new Gson();
        Type type = new TypeToken<RequestGroup>() {
        }.getType();
        String json = gson.toJson(list, type);
        return json;
    }
}
