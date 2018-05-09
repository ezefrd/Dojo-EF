package business

import enums.DestinationType

/**
 * Created by efridman on 7/5/18.
 */
class AddressListBO extends LinkedHashSet <AddressBO> implements Serializable{

    public AddressBO getAddressById(Long addressId) {
        return this.find { it.id == addressId }
    }

    public AddressBO findDefaultAddress() {
        // @smell @ricardobevi muchas validaciónes para devolver el default
        AddressBO defaultAddress = null

        if(this.size() > 0) {
            defaultAddress = this.find { it.defaultValue }

            if (defaultAddress == null) {
                defaultAddress = this.first()
            }
        }

        return defaultAddress
    }


    /**
     * Devuelve una lista de AddressBO ordenados con el AddressBO del addressId recibido como primer elemento.
     * Si el addressId es null, entonces devuelve el AddressBO default como primer elemento.
     * @param addressId
     * @return
     */
    public AddressListBO sortAddressOrDefaultFirst(Long addressId = null) {
        // nueva lista con el resultado
        AddressListBO finalList = new AddressListBO()

        // buscamos la dirección que va a ir primera
        AddressBO firstAddress = addressId ? this.getAddressById(addressId) : this.findDefaultAddress()

        if (firstAddress) {
            // si tenemos dirección para ordenar, la agregamos en la primera posición
            finalList.add(firstAddress)

            // concatenamos al final el resto de la lista
            finalList.addAll(this.minus(firstAddress))
        } else {

            // por default devolvemos la lista tal cual estaba
            finalList = (AddressListBO)this.clone()
        }

        return finalList
    }

    /**
     * Devuelve una lista de AddressBO con el AddressBO del addressId recibido como primer elemento.
     * Recibe un DestinationBO con un addressId, si el DestinationBO no es de tipo ADDRESS, lo ignora.
     *
     * @param addressDestinationBO
     * @return
     */
    public AddressListBO sortAddressOrDefaultFirst(DestinationBO addressDestinationBO) {

        if (addressDestinationBO && addressDestinationBO.isAddressType()) {
            // intentamos tomar el addressId si tenemos un destination de tipo ADDRESS
            return this.sortAddressOrDefaultFirst(new Long(addressDestinationBO.value))
        }

        return this.sortAddressOrDefaultFirst()
    }

    @Override
    public boolean add(AddressBO addressBO) {
        if(super.add(addressBO)){
            return true
        }
        return this.replace(this.getAddressById(addressBO.id), addressBO)
    }

    //TODO mejorar este paso
    public boolean replace(AddressBO addressBOfrom, AddressBO addressBOto) {
        if(addressBOfrom && addressBOto) {
            this.remove(addressBOfrom)
            return this.add(addressBOto)
        }
        return false
    }

}