/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inoutbox.Domain;

import DbAccess.Database;
import java.util.List;


/**
 *
 * @author Abdullah
 */
public class Outbox {

    private String _outboxNo;
    private String _date;
    private String _description;
    private String _destination;
    private Database _db ;

    public Outbox(String no, String date, String descr, String dest) {
        this._outboxNo = no;
        this._date = date;
        this._description = descr;
        this._destination = dest;
        _db = new Database("Outboxes");
    }

    public String getOutboxNo() {
        return _outboxNo;
    }

    public void setOutboxNo(String value) {
        _outboxNo = value;
    }

    public String getDate() {
        return _date;
    }

    public void setDate(String value) {
        _date = value;
    }

    public String getDescription() {
        return _description;
    }
    public void setDescription(String value)
    {
        _description = value;
    }
    public String getDestination()
    {
        return _destination;
    }
    public void setDestination(String value)
    {
        _destination =value;
    }
    public Outbox getOutbox(String no) throws Exception
    {
        throw new Exception();
    }
    public List<Outbox> getoutboxes()throws Exception
    {
        throw new Exception();
    }
    public boolean save()throws Exception
    {
        String[] values = new String[4];
        values[0]  = _outboxNo;
        values[1] = _date;
        values[2] = _description;
        values[3] = _destination;
        
        return _db.Save(values);
        
    }
    
}
