import referenzixx.*
import referenzixx.refs.*
import referenzixx.ui.*
import referenzixx.parser.*
import referenzixx.database.*
import org.fest.swing.fixture.*
import org.jbibtex.Key
import org.jbibtex.BibTeXEntry
import java.awt.Toolkit
import java.awt.datatransfer.Clipboard
import java.awt.datatransfer.DataFlavor

description "Arto voi helposti kopioida koko bibtexin leikepoydalle"

scenario "Bibtex on juuri avattu ja kopioidaan sisältö leikepoydalle", {
  
        File file = new File("src/test/veryshort.bib")
        DatabaseUtils dbu = new DatabaseUtils(file)
    
    when "Kopioidaan leikepoydalle", {
        dbu.copyToClipboard()
    }
    then "Leikepoydalla on sama sisaltö kuin bibtexissa", {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        String cb = (String) clipboard.getData(DataFlavor.stringFlavor);
  
        new BibtexReader().getBibFileAsString(file).shouldBeEqualTo(cb)
    }
}

scenario "Bibtexiin kopioidaan leikepöydälle lisäyksen jälkeen", {

        File file = new File("src/test/referenzixx.bib")
        DatabaseUtils dbu = new DatabaseUtils(file)
        dbu.addEntry(new BibTeXEntry(new Key("book"), new Key("ZZ99")))
    
    when "Kopioidaan leikepoydalle", {
        dbu.copyToClipboard();
    }
    then "Leikepoydalla on sama sisalto kuin bibtexissa", {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        String cb = (String) clipboard.getData(DataFlavor.stringFlavor);
  
        new BibtexReader().getBibFileAsString(file).shouldBeEqualTo(cb)
    }
}
