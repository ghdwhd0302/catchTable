package com.catchmind.catchtable.domain;

import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@ToString(callSuper = true)
@Table(name = "review")
public class Review extends AuditingFields{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="rev_idx")
    private Long id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "pr_idx")
    private Profile profile;
    private Long revLike;
    private String revContent;
    private double revScore;
    @ManyToOne(optional = false)
    @JoinColumn(name = "resa_bis_name")
    private ResAdmin resAdmin;

    private String orgNm;

    private String savedNm;

    private String savedPath;
    @ManyToOne(optional = false)
    @JoinColumn(name = "res_idx")
    private Reserve reserve;

    protected Review(){}

    @Builder
    public Review(Long id, Profile profile, Long revLike, String revContent, double revScore, ResAdmin resAdmin, String orgNm, String savedNm, String savedPath, Reserve reserve) {
        this.id = id;
        this.profile = profile;
        this.revLike = revLike;
        this.revContent = revContent;
        this.revScore = revScore;
        this.resAdmin = resAdmin;
        this.orgNm = orgNm;
        this.savedNm = savedNm;
        this.savedPath = savedPath;
        this.reserve = reserve;
    }

    public Review(Profile profile, String revContent, double revScore, ResAdmin resAdmin, String orgNm, String savedNm, String savedPath, Reserve reserve) {
        this.profile = profile;
        this.revContent = revContent;
        this.revScore = revScore;
        this.resAdmin = resAdmin;
        this.orgNm = orgNm;
        this.savedNm = savedNm;
        this.savedPath = savedPath;
        this.reserve = reserve;
    }

    public static Review of(Profile profile,String revContent, double revScore, ResAdmin resAdmin, String orgNm, String savedNm, String savedPath, Reserve reserve) {
        return new Review(profile,revContent,revScore,resAdmin,orgNm,savedNm,savedPath,reserve);
    }
}
