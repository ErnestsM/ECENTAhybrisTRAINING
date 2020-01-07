package de.hybris.training.facades.forms;

public class UpdateProfileForm {

    private String titleCode;
    private String firstName;
    private String lastName;
    private String phoneNumber;



    public String getTitleCode()
    {
        return titleCode;
    }


    public void setTitleCode(final String titleCode)
    {
        this.titleCode = titleCode;
    }


    public String getFirstName()
    {
        return firstName;
    }


    public void setFirstName(final String firstName)
    {
        this.firstName = firstName;
    }


    public String getLastName()
    {
        return lastName;
    }



    public void setLastName(final String lastName)
    {
        this.lastName = lastName;
    }


    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(final String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }


}
