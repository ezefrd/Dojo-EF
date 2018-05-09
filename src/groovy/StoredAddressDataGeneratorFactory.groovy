/**
 * Created by efridman on 7/5/18.
 */
class StoredAddressDataGeneratorFactory {
    public static final Set<Class<StoredAddressDataGenerator>> STORED_ADDRESS = [
            StoredAddressDataGeneratorMLA
    ].asImmutable()

    StoredAddressDataGenerator forSite(String siteId){
        return STORED_ADDRESS.collect { it.newInstance() }
                .find { it.appliesTo(siteId) } ?: StoredAddressDataGeneratorDefault.newInstance()
    }
}
