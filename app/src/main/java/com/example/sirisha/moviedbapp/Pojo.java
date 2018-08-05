package com.example.sirisha.moviedbapp;

/**
 * Created by sirisha on 11-05-2018.
 */

class Pojo {

    String poster2,Poster,title,analysis,rel_date,lang,mtitle;
    double vote_count,vote_avg,Ident,popularity;
    boolean vedio,adult;


    public Pojo(String poster2, String poster, String title,
                String analysis, String rel_date, double vote_avg,
                double vote_count, double popularity, boolean video,
                double ident, boolean adult, String mtitle, String lang) {
        this.poster2=poster2;
        this.Poster=poster;
        this.title=title;
        this.analysis=analysis;
        this.rel_date=rel_date;
        this.lang=lang;
        this.mtitle=mtitle;
        this.vote_count=vote_count;
        this.vote_avg=vote_avg;
        this.Ident=ident;
        this.popularity=popularity;
        this.vedio=video;
        this.adult=adult;

    }

    public String getPoster2() {
        return poster2;
    }

    public void setPoster2(String poster2) {
        this.poster2 = poster2;
    }

    public String getPoster() {
        return Poster;
    }

    public void setPoster(String poster) {
        Poster = poster;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public String getRel_date() {
        return rel_date;
    }

    public void setRel_date(String rel_date) {
        this.rel_date = rel_date;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getMtitle() {
        return mtitle;
    }

    public void setMtitle(String mtitle) {
        this.mtitle = mtitle;
    }

    public double getVote_count() {
        return vote_count;
    }

    public void setVote_count(double vote_count) {
        this.vote_count = vote_count;
    }

    public double getVote_avg() {
        return vote_avg;
    }

    public void setVote_avg(double vote_avg) {
        this.vote_avg = vote_avg;
    }

    public double getIdent() {
        return Ident;
    }

    public void setIdent(double ident) {
        Ident = ident;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public boolean isVedio() {
        return vedio;
    }

    public void setVedio(boolean vedio) {
        this.vedio = vedio;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }
}
