package com.catchmind.catchtable.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@Getter
@ToString
@Entity
public class Profile extends AuditingFields {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prIdx;
    @Setter @Column(unique = true, length = 100) private String prNick;
    @Setter @Column(nullable = false, length = 100) private String prName;
    @Setter @Column(length = 2000) private String prIntro;
    @Setter @Column(length = 100) private String prRegion;
    @Setter @Column(length = 100, nullable = false) private String prHp;
    @Setter @Column(length = 100, nullable = false) private String prUserpw;
    @Setter @Column(length = 10) private String prGender;
    @Setter @Column(length = 100) private String prBirth;
    @Setter @Column(length = 2000) private String prMemo;
    @Setter private int prReview;    @Setter private int prNoshow;
    @Setter private boolean prBlock;


    protected Profile() {}

    @Builder
    public Profile(Long prIdx, String prNick, String prName, String prIntro, String prRegion, String prHp, String prUserpw, String prGender, String prBirth, String prMemo, int prReview, int prNoshow, boolean prBlock) {
        this.prIdx = prIdx;
        this.prNick = prNick;
        this.prName = prName;
        this.prIntro = prIntro;
        this.prRegion = prRegion;
        this.prHp = prHp;
        this.prUserpw = prUserpw;
        this.prGender = prGender;
        this.prBirth = prBirth;
        this.prMemo = prMemo;
        this.prReview = prReview;
        this.prNoshow = prNoshow;
        this.prBlock = prBlock;
    }



    public static Profile of(Long prIdx, String prNick, String prName, String prIntro, String prRegion, String prHp, String prUserpw, String prGender, String prBirth, String prMemo, int prReview, int prNoshow, boolean prBlock) {
        return new Profile(prIdx, prNick, prName, prIntro, prRegion, prHp, prUserpw, prGender, prBirth, prMemo, prReview, prNoshow, prBlock);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prIdx);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof Profile profile)) return false;
        return prIdx != null && prIdx.equals(profile.prIdx);
    }
}
