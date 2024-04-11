
package com.movie.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.movie.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddActor_QNAME = new QName("http://service.movie.com/", "addActor");
    private final static QName _AddActorResponse_QNAME = new QName("http://service.movie.com/", "addActorResponse");
    private final static QName _AddMovie_QNAME = new QName("http://service.movie.com/", "addMovie");
    private final static QName _AddMovieResponse_QNAME = new QName("http://service.movie.com/", "addMovieResponse");
    private final static QName _GetActorsByMovie_QNAME = new QName("http://service.movie.com/", "getActorsByMovie");
    private final static QName _GetActorsByMovieResponse_QNAME = new QName("http://service.movie.com/", "getActorsByMovieResponse");
    private final static QName _GetMovieByTitle_QNAME = new QName("http://service.movie.com/", "getMovieByTitle");
    private final static QName _GetMovieByTitleResponse_QNAME = new QName("http://service.movie.com/", "getMovieByTitleResponse");
    private final static QName _GetMovieRating_QNAME = new QName("http://service.movie.com/", "getMovieRating");
    private final static QName _GetMovieRatingResponse_QNAME = new QName("http://service.movie.com/", "getMovieRatingResponse");
    private final static QName _GetMoviesByActor_QNAME = new QName("http://service.movie.com/", "getMoviesByActor");
    private final static QName _GetMoviesByActorResponse_QNAME = new QName("http://service.movie.com/", "getMoviesByActorResponse");
    private final static QName _LinkMovieToActor_QNAME = new QName("http://service.movie.com/", "linkMovieToActor");
    private final static QName _LinkMovieToActorResponse_QNAME = new QName("http://service.movie.com/", "linkMovieToActorResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.movie.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddActor }
     * 
     */
    public AddActor createAddActor() {
        return new AddActor();
    }

    /**
     * Create an instance of {@link AddActorResponse }
     * 
     */
    public AddActorResponse createAddActorResponse() {
        return new AddActorResponse();
    }

    /**
     * Create an instance of {@link AddMovie }
     * 
     */
    public AddMovie createAddMovie() {
        return new AddMovie();
    }

    /**
     * Create an instance of {@link AddMovieResponse }
     * 
     */
    public AddMovieResponse createAddMovieResponse() {
        return new AddMovieResponse();
    }

    /**
     * Create an instance of {@link GetActorsByMovie }
     * 
     */
    public GetActorsByMovie createGetActorsByMovie() {
        return new GetActorsByMovie();
    }

    /**
     * Create an instance of {@link GetActorsByMovieResponse }
     * 
     */
    public GetActorsByMovieResponse createGetActorsByMovieResponse() {
        return new GetActorsByMovieResponse();
    }

    /**
     * Create an instance of {@link GetMovieByTitle }
     * 
     */
    public GetMovieByTitle createGetMovieByTitle() {
        return new GetMovieByTitle();
    }

    /**
     * Create an instance of {@link GetMovieByTitleResponse }
     * 
     */
    public GetMovieByTitleResponse createGetMovieByTitleResponse() {
        return new GetMovieByTitleResponse();
    }

    /**
     * Create an instance of {@link GetMovieRating }
     * 
     */
    public GetMovieRating createGetMovieRating() {
        return new GetMovieRating();
    }

    /**
     * Create an instance of {@link GetMovieRatingResponse }
     * 
     */
    public GetMovieRatingResponse createGetMovieRatingResponse() {
        return new GetMovieRatingResponse();
    }

    /**
     * Create an instance of {@link GetMoviesByActor }
     * 
     */
    public GetMoviesByActor createGetMoviesByActor() {
        return new GetMoviesByActor();
    }

    /**
     * Create an instance of {@link GetMoviesByActorResponse }
     * 
     */
    public GetMoviesByActorResponse createGetMoviesByActorResponse() {
        return new GetMoviesByActorResponse();
    }

    /**
     * Create an instance of {@link LinkMovieToActor }
     * 
     */
    public LinkMovieToActor createLinkMovieToActor() {
        return new LinkMovieToActor();
    }

    /**
     * Create an instance of {@link LinkMovieToActorResponse }
     * 
     */
    public LinkMovieToActorResponse createLinkMovieToActorResponse() {
        return new LinkMovieToActorResponse();
    }

    /**
     * Create an instance of {@link Movie }
     * 
     */
    public Movie createMovie() {
        return new Movie();
    }

    /**
     * Create an instance of {@link Actor }
     * 
     */
    public Actor createActor() {
        return new Actor();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddActor }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddActor }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.movie.com/", name = "addActor")
    public JAXBElement<AddActor> createAddActor(AddActor value) {
        return new JAXBElement<AddActor>(_AddActor_QNAME, AddActor.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddActorResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddActorResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.movie.com/", name = "addActorResponse")
    public JAXBElement<AddActorResponse> createAddActorResponse(AddActorResponse value) {
        return new JAXBElement<AddActorResponse>(_AddActorResponse_QNAME, AddActorResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddMovie }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddMovie }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.movie.com/", name = "addMovie")
    public JAXBElement<AddMovie> createAddMovie(AddMovie value) {
        return new JAXBElement<AddMovie>(_AddMovie_QNAME, AddMovie.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddMovieResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddMovieResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.movie.com/", name = "addMovieResponse")
    public JAXBElement<AddMovieResponse> createAddMovieResponse(AddMovieResponse value) {
        return new JAXBElement<AddMovieResponse>(_AddMovieResponse_QNAME, AddMovieResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetActorsByMovie }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetActorsByMovie }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.movie.com/", name = "getActorsByMovie")
    public JAXBElement<GetActorsByMovie> createGetActorsByMovie(GetActorsByMovie value) {
        return new JAXBElement<GetActorsByMovie>(_GetActorsByMovie_QNAME, GetActorsByMovie.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetActorsByMovieResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetActorsByMovieResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.movie.com/", name = "getActorsByMovieResponse")
    public JAXBElement<GetActorsByMovieResponse> createGetActorsByMovieResponse(GetActorsByMovieResponse value) {
        return new JAXBElement<GetActorsByMovieResponse>(_GetActorsByMovieResponse_QNAME, GetActorsByMovieResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMovieByTitle }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetMovieByTitle }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.movie.com/", name = "getMovieByTitle")
    public JAXBElement<GetMovieByTitle> createGetMovieByTitle(GetMovieByTitle value) {
        return new JAXBElement<GetMovieByTitle>(_GetMovieByTitle_QNAME, GetMovieByTitle.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMovieByTitleResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetMovieByTitleResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.movie.com/", name = "getMovieByTitleResponse")
    public JAXBElement<GetMovieByTitleResponse> createGetMovieByTitleResponse(GetMovieByTitleResponse value) {
        return new JAXBElement<GetMovieByTitleResponse>(_GetMovieByTitleResponse_QNAME, GetMovieByTitleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMovieRating }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetMovieRating }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.movie.com/", name = "getMovieRating")
    public JAXBElement<GetMovieRating> createGetMovieRating(GetMovieRating value) {
        return new JAXBElement<GetMovieRating>(_GetMovieRating_QNAME, GetMovieRating.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMovieRatingResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetMovieRatingResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.movie.com/", name = "getMovieRatingResponse")
    public JAXBElement<GetMovieRatingResponse> createGetMovieRatingResponse(GetMovieRatingResponse value) {
        return new JAXBElement<GetMovieRatingResponse>(_GetMovieRatingResponse_QNAME, GetMovieRatingResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMoviesByActor }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetMoviesByActor }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.movie.com/", name = "getMoviesByActor")
    public JAXBElement<GetMoviesByActor> createGetMoviesByActor(GetMoviesByActor value) {
        return new JAXBElement<GetMoviesByActor>(_GetMoviesByActor_QNAME, GetMoviesByActor.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMoviesByActorResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetMoviesByActorResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.movie.com/", name = "getMoviesByActorResponse")
    public JAXBElement<GetMoviesByActorResponse> createGetMoviesByActorResponse(GetMoviesByActorResponse value) {
        return new JAXBElement<GetMoviesByActorResponse>(_GetMoviesByActorResponse_QNAME, GetMoviesByActorResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LinkMovieToActor }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LinkMovieToActor }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.movie.com/", name = "linkMovieToActor")
    public JAXBElement<LinkMovieToActor> createLinkMovieToActor(LinkMovieToActor value) {
        return new JAXBElement<LinkMovieToActor>(_LinkMovieToActor_QNAME, LinkMovieToActor.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LinkMovieToActorResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LinkMovieToActorResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.movie.com/", name = "linkMovieToActorResponse")
    public JAXBElement<LinkMovieToActorResponse> createLinkMovieToActorResponse(LinkMovieToActorResponse value) {
        return new JAXBElement<LinkMovieToActorResponse>(_LinkMovieToActorResponse_QNAME, LinkMovieToActorResponse.class, null, value);
    }

}
