import business.AddressBO
import business.AddressListBO
import business.CityBO
import business.CityListBO
import business.ContactBO
import business.DestinationBO
import business.ZipCodeBO
import enums.DestinationType
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by efridman on 8/5/18.
 */
class StoredAddressDataAddSpec extends Specification {
    StoredAddressDataAdd storedAddressDataAdd

    void setup() {

    }

    @Unroll
    void "test stored address data for #useCase"() {
        setup:
        storedAddressDataAdd = new StoredAddressDataAdd(addressListBO: addressList,
                addressDestinationBO: addressDestination,
                siteId: siteId)
        when:
        Map storedAddressMap = storedAddressDataAdd.execute()
        then:
        storedAddressMap.equals(expectedStoredAddressMap)
        where:
        useCase | addressList        | addressDestination        | siteId | expectedStoredAddressMap
        "MLA"   | genericAddressList | genericAddressDestination | "MLA"  | storedAddressMapMLA
        "MLX"   | genericAddressList | genericAddressDestination | "MLX"  | storedAddressMapDefault
    }

    private AddressListBO getGenericAddressList() {
        AddressBO addressBO = new AddressBO()

        addressBO.addressLine = "calle 12"
        addressBO.streetName = "calle"
        addressBO.streetNumber >> "12"
        addressBO.city = [id: "ciudad", name: "ciudad"]
        addressBO.country = [id: "country", name: "Country"]
        addressBO.state = [id: "state", name: "State"]
        addressBO.municipality = [id: "municipality", name: "Municipality"]
        addressBO.neighborhood = [id: "neighborhood", name: "Neighborhood"]
        addressBO.zipCodeBO = new ZipCodeBO(zipCode: "1313", cities: [new CityBO(id: "sarasa"), new CityBO(id: "sarasa2")] as CityListBO)
        addressBO.zipCode = "1313"
        addressBO.contact = new ContactBO(name: "Alfredo", phoneNumber: "12345678")
        return [addressBO] as AddressListBO
    }

    private DestinationBO getGenericAddressDestination() {
        return new DestinationBO(type: DestinationType.ZIPCODE, value: "1313")
    }

    private Map getStoredAddressMapMLA() {
        return [
                title    : "Opciones de envio",
                addresses: [
                        [
                                id             : null,
                                zip_code       : "1313",
                                address_line   : "calle 12",
                                street_name    : "calle",
                                street_number  : null,
                                comment        : null,
                                city           : [id: "ciudad", name: "ciudad"],
                                neighborhood   : [id: "neighborhood", name: "Neighborhood"],
                                municipality   : [id: "municipality", name: "Municipality"],
                                state          : [id: "state", name: "State"],
                                country        : [id: "country", name: "Country"],
                                contact_info   : [
                                        title      : "Alfredo",
                                        description: "12345678",
                                        name       : "Alfredo",
                                        phone      : "12345678",
                                        type       : "contact"
                                ],
                                latitude       : null,
                                longitude      : null,
                                normalized     : false,
                                internal_number: "Mira como te hardcodeo numero",
                                between_streets: "Mira como te hardcodeo entre calles",
                                references     : "Mira como te hardocdeo referencia",
                                additional_info: "Mira como te hardcodeo numero"
                        ]
                ]
        ]
    }

    private Map getStoredAddressMapDefault() {
        return [
                title    : "Opciones de envio",
                addresses: [
                        [
                                id             : null,
                                zip_code       : "1313",
                                address_line   : "calle 12",
                                street_name    : "calle",
                                street_number  : null,
                                comment        : null,
                                city           : [id: "ciudad", name: "ciudad"],
                                neighborhood   : [id: "neighborhood", name: "Neighborhood"],
                                municipality   : [id: "municipality", name: "Municipality"],
                                state          : [id: "state", name: "State"],
                                country        : [id: "country", name: "Country"],
                                contact_info   : [
                                        title      : "Alfredo",
                                        description: "12345678",
                                        name       : "Alfredo",
                                        phone      : "12345678",
                                        type       : "contact"
                                ],
                                latitude       : null,
                                longitude      : null,
                                normalized     : false,
                                internal_number: "Mira como te hardcodeo numero",
                                between_streets: "Mira como te hardcodeo entre calles",
                                references     : "Mira como te hardocdeo referencia"
                        ]
                ]
        ]
    }
}
