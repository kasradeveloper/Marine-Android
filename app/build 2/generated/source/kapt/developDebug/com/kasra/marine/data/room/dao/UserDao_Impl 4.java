package com.kasra.marine.data.room.dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.kasra.marine.data.model.Address;
import com.kasra.marine.data.model.UserInfo;
import com.kasra.marine.data.model.permission.PermissionResponseModel;
import com.kasra.marine.data.network.ProductTypeConverter;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@SuppressWarnings({"unchecked", "deprecation"})
public final class UserDao_Impl implements UserDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<UserInfo> __insertionAdapterOfUserInfo;

  private final EntityInsertionAdapter<PermissionResponseModel> __insertionAdapterOfPermissionResponseModel;

  private final SharedSQLiteStatement __preparedStmtOfDeleteUserInfo;

  private final SharedSQLiteStatement __preparedStmtOfDeletePermission;

  public UserDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUserInfo = new EntityInsertionAdapter<UserInfo>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `user_info` (`sub`,`address`,`givenName`,`iss`,`website`,`aud`,`personnelId`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, UserInfo value) {
        if (value.getSub() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getSub());
        }
        final String _tmp;
        _tmp = ProductTypeConverter.PlaceJsonToArrayList(value.getAddress());
        if (_tmp == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, _tmp);
        }
        if (value.getGivenName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getGivenName());
        }
        if (value.getIss() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getIss());
        }
        if (value.getWebsite() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getWebsite());
        }
        if (value.getAud() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getAud());
        }
        if (value.getPersonnelId() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getPersonnelId());
        }
      }
    };
    this.__insertionAdapterOfPermissionResponseModel = new EntityInsertionAdapter<PermissionResponseModel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `permission` (`id`) VALUES (?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PermissionResponseModel value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__preparedStmtOfDeleteUserInfo = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM user_info";
        return _query;
      }
    };
    this.__preparedStmtOfDeletePermission = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM permission";
        return _query;
      }
    };
  }

  @Override
  public Object insertUserInfo(final UserInfo userInfo, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfUserInfo.insert(userInfo);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object insertPermission(final List<PermissionResponseModel> permission,
      final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfPermissionResponseModel.insert(permission);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object deleteUserInfo(final Continuation<? super Unit> p0) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteUserInfo.acquire();
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteUserInfo.release(_stmt);
        }
      }
    }, p0);
  }

  @Override
  public Object deletePermission(final Continuation<? super Unit> p0) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeletePermission.acquire();
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeletePermission.release(_stmt);
        }
      }
    }, p0);
  }

  @Override
  public Flow<UserInfo> getUserInfo() {
    final String _sql = "SELECT * FROM  user_info ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"user_info"}, new Callable<UserInfo>() {
      @Override
      public UserInfo call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSub = CursorUtil.getColumnIndexOrThrow(_cursor, "sub");
          final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
          final int _cursorIndexOfGivenName = CursorUtil.getColumnIndexOrThrow(_cursor, "givenName");
          final int _cursorIndexOfIss = CursorUtil.getColumnIndexOrThrow(_cursor, "iss");
          final int _cursorIndexOfWebsite = CursorUtil.getColumnIndexOrThrow(_cursor, "website");
          final int _cursorIndexOfAud = CursorUtil.getColumnIndexOrThrow(_cursor, "aud");
          final int _cursorIndexOfPersonnelId = CursorUtil.getColumnIndexOrThrow(_cursor, "personnelId");
          final UserInfo _result;
          if(_cursor.moveToFirst()) {
            final String _tmpSub;
            if (_cursor.isNull(_cursorIndexOfSub)) {
              _tmpSub = null;
            } else {
              _tmpSub = _cursor.getString(_cursorIndexOfSub);
            }
            final Address _tmpAddress;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfAddress)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfAddress);
            }
            _tmpAddress = ProductTypeConverter.PalceArrayListToJson(_tmp);
            final String _tmpGivenName;
            if (_cursor.isNull(_cursorIndexOfGivenName)) {
              _tmpGivenName = null;
            } else {
              _tmpGivenName = _cursor.getString(_cursorIndexOfGivenName);
            }
            final String _tmpIss;
            if (_cursor.isNull(_cursorIndexOfIss)) {
              _tmpIss = null;
            } else {
              _tmpIss = _cursor.getString(_cursorIndexOfIss);
            }
            final String _tmpWebsite;
            if (_cursor.isNull(_cursorIndexOfWebsite)) {
              _tmpWebsite = null;
            } else {
              _tmpWebsite = _cursor.getString(_cursorIndexOfWebsite);
            }
            final String _tmpAud;
            if (_cursor.isNull(_cursorIndexOfAud)) {
              _tmpAud = null;
            } else {
              _tmpAud = _cursor.getString(_cursorIndexOfAud);
            }
            final String _tmpPersonnelId;
            if (_cursor.isNull(_cursorIndexOfPersonnelId)) {
              _tmpPersonnelId = null;
            } else {
              _tmpPersonnelId = _cursor.getString(_cursorIndexOfPersonnelId);
            }
            _result = new UserInfo(_tmpSub,_tmpAddress,_tmpGivenName,_tmpIss,_tmpWebsite,_tmpAud,_tmpPersonnelId);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<PermissionResponseModel>> getPermissionModel() {
    final String _sql = "SELECT * FROM  permission ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"permission"}, new Callable<List<PermissionResponseModel>>() {
      @Override
      public List<PermissionResponseModel> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final List<PermissionResponseModel> _result = new ArrayList<PermissionResponseModel>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final PermissionResponseModel _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item = new PermissionResponseModel(_tmpId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
