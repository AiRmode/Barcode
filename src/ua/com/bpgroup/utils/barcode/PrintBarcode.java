package ua.com.bpgroup.utils.barcode;

import java.io.File;

import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;

public class PrintBarcode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		PrintBarcode printBarcode = new PrintBarcode();
		
		for(int i=0;i<10;i++){
			try {
				printBarcode.outputtingBarcodeAsPNG(i);
			} catch (BarcodeException e) {
				e.printStackTrace();
			}	
		}
	}

    public void outputtingBarcodeAsPNG(int i) throws BarcodeException {
        // get a Barcode from the BarcodeFactory
		Barcode barcode = BarcodeFactory.createCode128B("Ivanov.Andriy_12.12.1980_operator"+i);

        try {
            File f = new File("bars/mybarcode!"+i+".png");
            // Let the barcode image handler do the hard work
            BarcodeImageHandler.savePNG(barcode, f);
        } catch (Exception e) {
            // Error handling here
        }
    }
	
}
