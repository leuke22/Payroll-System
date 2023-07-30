package D_Forms;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.JPanel;

public class PrintPanel implements Printable {

    private JPanel panelToPrint;

    public PrintPanel(JPanel panelToPrint) {
        this.panelToPrint = panelToPrint;
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {

        if (pageIndex > 0) {
            return NO_SUCH_PAGE;
        }

        // Get the PageFormat with the panel size
        pageFormat = getPageFormat(panelToPrint);

        Graphics2D g2d = (Graphics2D) graphics;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

        panelToPrint.printAll(g2d);

        return PAGE_EXISTS;
    }

    public void print() throws PrinterException {
        PrinterJob printJob = PrinterJob.getPrinterJob();
        printJob.setPrintable(this);
        if (printJob.printDialog()) {
            printJob.print();
        }
    }

    private PageFormat getPageFormat(JPanel panel) {
        // get the size of the panel
        java.awt.Dimension panelSize = panel.getSize();

        // create a new page format with the panel size
        PageFormat pageFormat = new PageFormat();
        Paper paper = new Paper();
        paper.setSize(panelSize.width, panelSize.height);
        paper.setImageableArea(0, 0, panelSize.width, panelSize.height);
        pageFormat.setPaper(paper);

        return pageFormat;
    }
}
