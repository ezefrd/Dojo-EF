import business.AddressBO
import business.AddressListBO
import business.DestinationBO

/**
 * Created by efridman on 7/5/18.
 */
class StoredAddressDataAdd {

    //Se inyectan desde el test:
    AddressListBO addressListBO
    DestinationBO addressDestinationBO
    String siteId

    Map execute() {
        // ordenamos la lista dejando la default address primero
        AddressListBO sortedAddressListBO = addressListBO?.sortAddressOrDefaultFirst(addressDestinationBO)

        StoredAddressDataGeneratorFactory mapSelector = new StoredAddressDataGeneratorFactory()
        StoredAddressDataGenerator storedAddressDataGenerator = mapSelector.forSite(siteId)

        List<Map> addresses = sortedAddressListBO.collect { AddressBO addressBO ->
            return storedAddressDataGenerator.buildAddressMap(addressBO)
        }

        Map storedAddresses = [
                title    : "Opciones de envio",
                addresses: addresses
        ]

        return storedAddresses
    }

}
