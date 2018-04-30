package com.tw.Database;

import com.tw.Entity.Klass;

public class Database {

  private Klass klass;

  private Database(Klass klass) {
    this.klass = klass;
  }

  private static Database database=null;

  public static Database getDatabase() {
    if (database == null) {
      database = new Database(new Klass());
    }
    return database;
  }

  public Klass getKlass() {
    return klass;
  }

  public void setKlass(Klass klass) {
    this.klass = klass;
  }
}
