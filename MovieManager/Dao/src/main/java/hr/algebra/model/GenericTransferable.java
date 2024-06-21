/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.model;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

/**
 *
 * @author andru
 */
public class GenericTransferable<T> implements Transferable{   

    private final T data;
    private final DataFlavor flavor;

    public GenericTransferable(T data, Class<T> type) {
        this.data = data;
        this.flavor = new DataFlavor(type, type.getSimpleName());
    }

    @Override
    public DataFlavor[] getTransferDataFlavors() {
        return new DataFlavor[]{flavor};
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor) {
        return this.flavor.equals(flavor);
    }
    
    public DataFlavor getFlavor() {
        return flavor;
    }

    @Override
    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
        if (isDataFlavorSupported(flavor)) {
            return data;
        }
        throw new UnsupportedFlavorException(flavor);
    }
    
}
