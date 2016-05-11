package org.eclipse.scout.contacts.shared.organization;

import javax.annotation.Generated;

import org.eclipse.scout.rt.shared.data.basic.table.AbstractTableRowData;
import org.eclipse.scout.rt.shared.data.page.AbstractTablePageData;

/**
 * <b>NOTE:</b><br>
 * This class is auto generated by the Scout SDK. No manual modifications recommended.
 */
@Generated(value = "org.eclipse.scout.contacts.client.organization.OrganizationTablePage", comments = "This class is auto generated by the Scout SDK. No manual modifications recommended.")
public class OrganizationTablePageData extends AbstractTablePageData {

  private static final long serialVersionUID = 1L;

  @Override
  public OrganizationTableRowData addRow() {
    return (OrganizationTableRowData) super.addRow();
  }

  @Override
  public OrganizationTableRowData addRow(int rowState) {
    return (OrganizationTableRowData) super.addRow(rowState);
  }

  @Override
  public OrganizationTableRowData createRow() {
    return new OrganizationTableRowData();
  }

  @Override
  public Class<? extends AbstractTableRowData> getRowType() {
    return OrganizationTableRowData.class;
  }

  @Override
  public OrganizationTableRowData[] getRows() {
    return (OrganizationTableRowData[]) super.getRows();
  }

  @Override
  public OrganizationTableRowData rowAt(int index) {
    return (OrganizationTableRowData) super.rowAt(index);
  }

  public void setRows(OrganizationTableRowData[] rows) {
    super.setRows(rows);
  }

  public static class OrganizationTableRowData extends AbstractTableRowData {

    private static final long serialVersionUID = 1L;
    public static final String organizationIdElement = "organizationId";
    public static final String nameElement = "name";
    public static final String cityElement = "city";
    public static final String countryElement = "country";
    public static final String homepageElement = "homepage";

    private String organizationId;
    private String name;
    private String city;
    private String country;
    private String homepage;

    public String getOrganizationId() {
      return organizationId;
    }

    public void setOrganizationId(String newOrganizationId) {
      organizationId = newOrganizationId;
    }

    public String getName() {
      return name;
    }

    public void setName(String newName) {
      name = newName;
    }

    public String getCity() {
      return city;
    }

    public void setCity(String newCity) {
      city = newCity;
    }

    public String getCountry() {
      return country;
    }

    public void setCountry(String newCountry) {
      country = newCountry;
    }

    public String getHomepage() {
      return homepage;
    }

    public void setHomepage(String newHomepage) {
      homepage = newHomepage;
    }
  }
}
