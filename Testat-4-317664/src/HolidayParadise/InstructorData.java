/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HolidayParadise;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Benedict
 */
public class InstructorData 
{
    private static ArrayList<Instructor> instructorList = new ArrayList<Instructor>();
    /**
     * crats edit the cloums and fiels them with the values of the arrylist
     */
    public static void getInstructorList() 
    {
        String col[] = {"ID", "Name", "Prename", "Birthdate", "Sex", "Spesification", "Workrealtion", "CoursID"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0) {
            public boolean isCellEditable(int row, int col) {
                //first column not editable
                if (col == 0) {
                    return false;
                } else {
                    return true;
                }
            }
        };
        Gui.MainFrame.instructorTable.setModel(tableModel);
        for (int i = 0; i < instructorList.size(); i++) {
            int id = instructorList.get(i).getInstructorID();
            String name = instructorList.get(i).getInstructorName();
            String prename = instructorList.get(i).getInstructorPrname();
            LocalDate birthdate = instructorList.get(i).getBirthDate();
            String birthdateAsString = String.valueOf(birthdate);
            String spesification = instructorList.get(i).getSpesification();
            String sex = instructorList.get(i).getSex();
            String workrelation = instructorList.get(i).getWorkRelation();
            String courseIDForTable;
            StringBuffer output = new StringBuffer(110);
            for (int j = 0; j < instructorList.get(i).getCoursIdListSize(); j++) {
                output.append(instructorList.get(i).getCourseIDList(j));
                output.append(",");
        }
        courseIDForTable = output.toString();
            
            Object[] item = {id, name, prename, birthdateAsString, sex, spesification, workrelation, courseIDForTable};
            tableModel.addRow(item);
        }           
    }
  
    /**
     * delets an Instructor
     */
   public static void deleteInstructorfromTable() {
        DefaultTableModel model3 = (DefaultTableModel) Gui.MainFrame.instructorTable.getModel();
        int[] selectedRows = Gui.MainFrame.instructorTable.getSelectedRows();
        if (selectedRows.length > 0) {
            for (int i = selectedRows.length - 1; i >= 0; i--) {
                String idString = (Gui.MainFrame.instructorTable.getValueAt(selectedRows[i], 0).toString());
                int id = Integer.valueOf(idString);
                for (int x = instructorList.size() - 1; x >= 0; x--) {
                    if (instructorList.get(x).getInstructorID() == (id)) {
                        instructorList.remove(id);
                    }
                }
                model3.removeRow(selectedRows[i]);
            }
        }
    }
   
   /**
    * showes the instructor on the table
    */
   public static void showInstructors()
   {
        getInstructorList();
        DefaultTableModel model = (DefaultTableModel)Gui.MainFrame.instructorTable.getModel();
        TableModelListener modelListener = new TableModelListener() 
        {
            /**
             * changes the table
             */
            public void tableChanged(TableModelEvent evt) 
            {
                try 
                {
                    Boolean error = false;
                    int rows = Gui.MainFrame.instructorTable.getRowCount();
                    for (int row = 0; row < rows; row++) 
                    {
                        int id = (int) Gui.MainFrame.instructorTable.getValueAt(row, 0);
                        String name = (String) Gui.MainFrame.instructorTable.getValueAt(row, 1);
                        String prename = (String) Gui.MainFrame.instructorTable.getValueAt(row, 2);
                        String birthdate = (String) Gui.MainFrame.instructorTable.getValueAt(row, 3);
                        String sex = (String) Gui.MainFrame.instructorTable.getValueAt(row, 4);
                        String spesification = (String) Gui.MainFrame.instructorTable.getValueAt(row, 5);
                        String workrelation = (String) Gui.MainFrame.instructorTable.getValueAt(row, 6);
                        String course = (String) Gui.MainFrame.instructorTable.getValueAt(row, 7);
                        String[] array = course.split("\\,"); 
                    
                        String regexSex = "^(?:male|female|diverse)$";
                        Pattern pattern1 = Pattern.compile(regexSex);
                        Matcher matchSex;
                        matchSex = pattern1.matcher(sex);
                        if (!(matchSex.find() && matchSex.group().equals(sex))) 
                        {
                            JOptionPane.showMessageDialog(new JFrame(), "Error, sex is not valid. Needs to be male, female or diverse", "Error", JOptionPane.ERROR_MESSAGE);
                            error = true;
                        }                                 
                        if (error == false)
                        { 
                            instructorList.get(id).setInstructorName(name);
                            instructorList.get(id).setInstructorPrname(prename);
                            instructorList.get(id).setSpesification(spesification);
                            instructorList.get(id).setWorkRelation(workrelation);
                            instructorList.get(id).setBirthDate(LocalDate.parse(birthdate));
                            instructorList.get(id).setSex(sex);
                        }
                    }                        
                }
                catch (IndexOutOfBoundsException ex) 
                {
                }
                catch (Exception e) 
                {
                    JOptionPane.showMessageDialog(new JFrame(), "Error, not saved. Please check Time H:mm, Date YYYY-MM-DD", "Error", JOptionPane.ERROR_MESSAGE);
                    System.out.println(e);
                }
            } 
        };
        model.addTableModelListener(modelListener);
    }
   
    /**
     * Method to change an instructor
     * @param index
     * @param userInputOld
     * @param userInputNew
     */
    public void changeInstructor(int index, String userInputOld, String userInputNew) {
        switch (userInputOld) 
        {
            case "Name":
                this.instructorList.get(index).setInstructorName(userInputNew);
                break;
            case "Prename":

                this.instructorList.get(index).setInstructorPrname(userInputNew);
                break;

            case "Speciality":
                this.instructorList.get(index).setSpesification(userInputNew);
                break;

            case "Sex":
                this.instructorList.get(index).setSex(userInputNew);
                break;
                
            case "Workrelation":
                this.instructorList.get(index).setWorkRelation(userInputNew);
                break;
                
            case "Birthdate":
                this.instructorList.get(index).setBirthDate(LocalDate.parse(userInputNew));
                break;            
            
            default:
                break;

        }
    }
    
    /**
     * creats an instructor and saves it in the arraylist
     * @param name
     * @param prename
     * @param birthdate
     * @param sex
     * @param Spesification
     * @param Workrelation 
     */
    public void setInstructor(String name, String prename, LocalDate birthdate, String sex, String Spesification, String Workrelation)
    {
        Instructor instructor = new Instructor();
        
        instructor.setInstructorName(name);
        instructor.setInstructorPrname(prename);
        instructor.setBirthDate(birthdate);
        instructor.setSex(sex);
        instructor.setSpesification(Spesification);
        instructor.setWorkRelation(Workrelation);
        
        instructorList.add(instructor);
    }
}
