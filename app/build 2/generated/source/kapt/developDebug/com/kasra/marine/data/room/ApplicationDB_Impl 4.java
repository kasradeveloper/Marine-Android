package com.kasra.marine.data.room;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.kasra.marine.data.room.dao.UserDao;
import com.kasra.marine.data.room.dao.UserDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ApplicationDB_Impl extends ApplicationDB {
  private volatile UserDao _userDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Person` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `user_info` (`sub` TEXT NOT NULL, `address` TEXT, `givenName` TEXT, `iss` TEXT, `website` TEXT, `aud` TEXT, `personnelId` TEXT, PRIMARY KEY(`sub`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `permission` (`id` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'bd0669d63382dbe3a9e95bcee717f7ca')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `Person`");
        _db.execSQL("DROP TABLE IF EXISTS `user_info`");
        _db.execSQL("DROP TABLE IF EXISTS `permission`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsPerson = new HashMap<String, TableInfo.Column>(1);
        _columnsPerson.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPerson = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPerson = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPerson = new TableInfo("Person", _columnsPerson, _foreignKeysPerson, _indicesPerson);
        final TableInfo _existingPerson = TableInfo.read(_db, "Person");
        if (! _infoPerson.equals(_existingPerson)) {
          return new RoomOpenHelper.ValidationResult(false, "Person(com.kasra.marine.data.model.user.Person).\n"
                  + " Expected:\n" + _infoPerson + "\n"
                  + " Found:\n" + _existingPerson);
        }
        final HashMap<String, TableInfo.Column> _columnsUserInfo = new HashMap<String, TableInfo.Column>(7);
        _columnsUserInfo.put("sub", new TableInfo.Column("sub", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserInfo.put("address", new TableInfo.Column("address", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserInfo.put("givenName", new TableInfo.Column("givenName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserInfo.put("iss", new TableInfo.Column("iss", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserInfo.put("website", new TableInfo.Column("website", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserInfo.put("aud", new TableInfo.Column("aud", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserInfo.put("personnelId", new TableInfo.Column("personnelId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUserInfo = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUserInfo = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUserInfo = new TableInfo("user_info", _columnsUserInfo, _foreignKeysUserInfo, _indicesUserInfo);
        final TableInfo _existingUserInfo = TableInfo.read(_db, "user_info");
        if (! _infoUserInfo.equals(_existingUserInfo)) {
          return new RoomOpenHelper.ValidationResult(false, "user_info(com.kasra.marine.data.model.UserInfo).\n"
                  + " Expected:\n" + _infoUserInfo + "\n"
                  + " Found:\n" + _existingUserInfo);
        }
        final HashMap<String, TableInfo.Column> _columnsPermission = new HashMap<String, TableInfo.Column>(1);
        _columnsPermission.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPermission = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPermission = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPermission = new TableInfo("permission", _columnsPermission, _foreignKeysPermission, _indicesPermission);
        final TableInfo _existingPermission = TableInfo.read(_db, "permission");
        if (! _infoPermission.equals(_existingPermission)) {
          return new RoomOpenHelper.ValidationResult(false, "permission(com.kasra.marine.data.model.permission.PermissionResponseModel).\n"
                  + " Expected:\n" + _infoPermission + "\n"
                  + " Found:\n" + _existingPermission);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "bd0669d63382dbe3a9e95bcee717f7ca", "6995c47ebba8c11181d002f39fb84552");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "Person","user_info","permission");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `Person`");
      _db.execSQL("DELETE FROM `user_info`");
      _db.execSQL("DELETE FROM `permission`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(UserDao.class, UserDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public UserDao userDao() {
    if (_userDao != null) {
      return _userDao;
    } else {
      synchronized(this) {
        if(_userDao == null) {
          _userDao = new UserDao_Impl(this);
        }
        return _userDao;
      }
    }
  }
}
