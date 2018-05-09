import business.AddressBO

/**
 * Created by efridman on 7/5/18.
 */
class StoredAddressDataGeneratorDefault extends AbstractStoredAddressDataGenerator implements StoredAddressDataGenerator{

    boolean appliesTo(String siteId) {
        return false
    }

    Map buildAddressMap(AddressBO addressBO) {
        return [
                id             : addressBO.id,
                zip_code       : addressBO.zipCode,
                address_line   : addressBO.addressLine,
                street_name    : addressBO.streetName,
                street_number  : addressBO.streetNumber,
                comment        : addressBO.additionalInfo,
                city           : [
                        id  : addressBO.city.id,
                        name: addressBO.city.name
                ],
                neighborhood   : [
                        id  : addressBO.neighborhood.id,
                        name: addressBO.neighborhood.name
                ],
                municipality   : [
                        id  : addressBO.municipality.id,
                        name: addressBO.municipality.name
                ],
                state          : [
                        id  : addressBO.state.id,
                        name: addressBO.state.name
                ],
                country        : [
                        id  : addressBO.country.id,
                        name: addressBO.country.name
                ],
                contact_info   : super.buildContactInfoBlock(addressBO.contact),
                latitude       : addressBO.geolocation?.latitude,
                longitude      : addressBO.geolocation?.longitude,
                normalized     : addressBO.normalized,
                internal_number: addressBO.internalNumber,
                between_streets: addressBO.betweenStreets,
                references     : addressBO.reference
        ]
    }
}