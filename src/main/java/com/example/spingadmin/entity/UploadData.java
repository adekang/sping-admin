package com.example.spingadmin.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 基础数据类
 *
 * @author adekang
 **/
@Data
@EqualsAndHashCode
public class UploadData {
    @ExcelProperty("Publication Type")
    private String publicationType;

    @ExcelProperty("Authors")
    private String authors;

    @ExcelProperty("Book Authors")
    private String bookAuthors;

    @ExcelProperty("Book Editors")
    private String bookEditors;

    @ExcelProperty("Boob Group Authors")
    private String boobGroupAuthors;


    @ExcelProperty("Author Full Names")
    private String authorFullNames;
    @ExcelProperty("Book Author Full Names")
    private String bookAuthorFullNames;

    @ExcelProperty("Group Authors")
    private String groupAuthors;

    @ExcelProperty("Article Title")
    private String articleTitle;

    @ExcelProperty("Source Title")
    private String sourceTitle;

    @ExcelProperty("Book Series Title")
    private String bookSeriesTitle;

    @ExcelProperty("Book Series Subtitle")
    private String bookSeriesSubtitle;

    @ExcelProperty("Language")
    private String language;

    @ExcelProperty("Document Type")
    private String documentType;

    @ExcelProperty("Conference Title")
    private String conferenceTitle;

    @ExcelProperty("Conference Date")
    private String conferenceDate;

    @ExcelProperty("Conference Location")
    private String conferenceLocation;

    @ExcelProperty("Conference Sponsor")
    private String conferenceSponsor;

    @ExcelProperty("Conference Host")
    private String conferenceHost;

    @ExcelProperty("Author Keywords")
    private String authorKeywords;

    @ExcelProperty("Keywords Plus")
    private String keywordsPlus;

    @ExcelProperty("Abstract")
    private String abstractText;

    @ExcelProperty("Addresses")
    private String addresses;

    @ExcelProperty("Affiliations")
    private String affiliations;

    @ExcelProperty("Reprint Addresses")
    private String reprintAddresses;

    @ExcelProperty("Email Addresses")
    private String emailAddresses;

    @ExcelProperty("Researcher IDs")
    private String researcherIds;

    @ExcelProperty("ORCIDs")
    private String orcids;

    @ExcelProperty("Funding Orgs")
    private String fundingOrgs;

    @ExcelProperty("Funding Name Preferred")
    private String fundingNamePreferred;

    @ExcelProperty("Funding Text")
    private String fundingText;

    @ExcelProperty("Cited References")
    private String citedReferences;

    @ExcelProperty("Cited Reference Count")
    private String citedReferenceCount;

    @ExcelProperty("Times Cited WoS Core")
    private String timesCitedWoSCore;

    @ExcelProperty("Times Cited All Databases")
    private String timesCitedAllDatabases;

    @ExcelProperty("Day of 180 Usage Count")
    private String dayOf180UsageCount;

    @ExcelProperty("Since 2013 Usage Count")
    private String since2013UsageCount;

    @ExcelProperty("Publisher")
    private String publisher;

    @ExcelProperty("Publisher City")
    private String publisherCity;

    @ExcelProperty("Publisher Address")
    private String publisherAddress;

    @ExcelProperty("ISSN")
    private String issn;

    @ExcelProperty("eISSN")
    private String eissn;

    @ExcelProperty("ISBN")
    private String isbn;

    @ExcelProperty("Journal Abbreviation")
    private String journalAbbreviation;

    @ExcelProperty("Journal ISO Abbreviation")
    private String journalIsoAbbreviation;

    @ExcelProperty("Publication Date")
    private String publicationDate;

    @ExcelProperty("Publication Year")
    private String publicationYear;

    @ExcelProperty("Volume")
    private String volume;

    @ExcelProperty("Issue")
    private String issue;

    @ExcelProperty("Part Number")
    private String partNumber;

    @ExcelProperty("Supplement")
    private String supplement;

    @ExcelProperty("Special Issue")
    private String specialIssue;

    @ExcelProperty("Meeting Abstract")
    private String meetingAbstract;

    @ExcelProperty("Start Page")
    private String startPage;

    @ExcelProperty("End Page")
    private String endPage;

    @ExcelProperty("Article Number")
    private String articleNumber;

    @ExcelProperty("DOI")
    private String doi;

    @ExcelProperty("DOI Link")
    private String doiLink;

    @ExcelProperty("Book DOI")
    private String bookDoi;

    @ExcelProperty("Early Access Date")
    private String earlyAccessDate;

    @ExcelProperty("Number of Pages")
    private String numberOfPages;

    @ExcelProperty("WoS Categories")
    private String wosCategories;

    @ExcelProperty("Web of Science Index")
    private String webOfScienceIndex;

    @ExcelProperty("Research Areas")
    private String researchAreas;

    @ExcelProperty("IDS Number")
    private String idsNumber;

    @ExcelProperty("PubMed ID")
    private String pubmedId;

    @ExcelProperty("Open Access Designations")
    private String openAccessDesignations;

    @ExcelProperty("Highly Cited Status")
    private String highlyCitedStatus;

    @ExcelProperty("Hot Paper Status")
    private String hotPaperStatus;

    @ExcelProperty("Date of Export")
    private String dateOfExport;

    @ExcelProperty("UT Unique WOS ID")
    private String utUniqueWosId;

    @ExcelProperty("Web of Science Record")
    private String webOfScienceRecord;

}