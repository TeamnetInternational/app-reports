package ro.teamnet.solutions.reportinator.load.jasper;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import ro.teamnet.solutions.reportinator.load.Loader;
import ro.teamnet.solutions.reportinator.load.LoaderException;

import java.io.IOException;
import java.io.InputStream;

/**
 * A {@link ro.teamnet.solutions.reportinator.load.Loader} implementation that
 * load a {@link java.io.InputStream} into a {@link net.sf.jasperreports.engine.design.JasperDesign} using
 * {@link net.sf.jasperreports.engine.xml.JRXmlLoader} method .
 * <p/>
 * In order to perform the load sequence of JRXmlLoader , the loadSource must not be null.
 *
 * @author Andrei.Marica
 * @version 1.0 Date: 2/11/2015
 */
public final class InputStreamLoader implements Loader<InputStream, JRReport> {
    /**
     * A method that loads an InputStream in a JasperDesign using {@link net.sf.jasperreports.engine.xml.JRXmlLoader}.
     *
     * @param loadSource given InputStream to be loaded in the JRXMLLoader.
     * @return JasperDesign generated by JRXmlLoader
     * @throws LoaderException
     */
    @Override
    public JRReport load(InputStream loadSource) throws LoaderException {

        JasperDesign jasperDesign;
        if (loadSource != null) {
            try {
                jasperDesign = JRXmlLoader.load(loadSource.available() != 0 ? loadSource : null);
            } catch (JRException | IOException e) {
                //Re-throw
                throw new LoaderException("Could not load " + loadSource.getClass().getCanonicalName() + " into a JRReport"
                        , e.getCause());
            }
        } else {
            throw new LoaderException(" Could not load resource of InputStream type to a JRReport:" +
                    " InputStream = null.");
        }
        return jasperDesign;
    }


}
