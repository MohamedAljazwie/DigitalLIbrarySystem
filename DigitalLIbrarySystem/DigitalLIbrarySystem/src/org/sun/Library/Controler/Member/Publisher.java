package org.sun.Library.Controler.Member;

import org.sun.Library.Bean.PersonInfo;

public class Publisher  implements Person {
    private PersonInfo info;
    public Publisher() {
        this(null);
    }
    public Publisher(PersonInfo info) {
        this.info=info;
    }

    public void setInfo(PersonInfo info) {
        this.info = info;
    }

    public PersonInfo getInfo() {
        return info;
    }
}
