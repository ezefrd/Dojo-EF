import business.AddressBO

/**
 * Created by efridman on 7/5/18.
 */
interface StoredAddressDataGenerator {
    boolean appliesTo(String siteId)

    Map buildAddressMap(AddressBO addressBO)
}
