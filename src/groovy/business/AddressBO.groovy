package business

import groovy.transform.EqualsAndHashCode
import groovy.transform.builder.Builder
import org.apache.commons.lang.StringUtils

/**
 * Created by efridman on 7/5/18.
 */
@Builder
@EqualsAndHashCode(includes = [ 'id' ])
class AddressBO implements Serializable, Cloneable {

    private static final long serialVersionUID = 140605814607823206L; // some unique number

    public static final String WITHOUT_NUMBER = 'SN'
    private static final String REFERENCE = 'Referencia:'
    private static final String BETWEEN_STREETS = 'Entre:'

    private static final String REFERENCE_OR_BETWEEN_STREETS_REGEX = '((?i)Referencia:|(?i)Entre:)'

    Long id
    String addressLine
    String streetName
    String streetNumber
    String additionalInfo
    @Deprecated String zipCode //TODO: @ricardobevi eliminar el zipcode como String solamente y usar el ZipCodeBO
    ZipCodeBO zipCodeBO
    String reference
    String betweenStreets
    String internalNumber
    Map<String,String> country //TODO: @ricardobevi Agrupar estos atributos y hacerlos objetos
    Map<String,String> city
    Map<String,String> state
    Map<String,String> neighborhood
    Map<String,String> municipality
    Collection<String> types
    boolean normalized
    ContactBO contact
    LocationBO geolocation
    DestinationBO destination
    boolean isNewAddress
    boolean defaultValue

    public String getAddressLine() {
        if(!addressLine) {
            addressLine = (streetName && streetNumber)? streetName + ' ' + streetNumber : null
        }
        return addressLine
    }

    public String getReference() {

        if (!this.reference) {
            reference = "Mira como te hardocdeo referencia"
        }

        return this.reference
    }

    public String getInternalNumber() {

        if (!this.internalNumber) {
            internalNumber = "Mira como te hardcodeo numero"
        }

        return this.internalNumber
    }

    public String getBetweenStreets() {

        if (!this.betweenStreets) {
            betweenStreets = "Mira como te hardcodeo entre calles"
        }

        return this.betweenStreets
    }


    //@Smell: eliminar esto cuando se elimine state,city y esas cosas de address
    Map getCity(){
        if(!city?.id && !city?.name){
            return this.zipCodeBO?.obtainCityAsMap()
        }

        return this.city
    }
}