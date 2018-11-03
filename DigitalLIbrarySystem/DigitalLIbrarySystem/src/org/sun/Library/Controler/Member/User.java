package org.sun.Library.Controler.Member;

import org.sun.Library.Bean.Access;

public class User extends Member {
public User() {
    this(null);
}
public User(Access access ) {
    this.access=access;
}
}
