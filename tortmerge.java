package someproject.model.decoder;

import java.util.Arrays;
import java.util.Calendar;

import someproject.model.TraceHistory;
import someproject.model.decoder.TT2Decoder_Layer1.TraceLayer1;
import someproject.model.decoder.TT2Decoder_Rest.TraceMarker;
import someproject.model.decoder.TT2Decoder_Rest.aTPrecisionTimestamp;
import someproject.model.decoder.TT2Decoder_Rest.aTTimestamp;

public class TT2Decoder {
    public static final String logtag = "TT2Decoder";
    public TT2Decoder_Scan			mTT2Decoder_Scan;
    public TT2Decoder_Layer1		mTT2Decoder_Layer1;
    public TT2Decoder_LayerMsg		mTT2Decoder_LayerMsg;
    public TT2Decoder_Rest			mTT2Decoder_Rest;
    public int trace_year = 2015;
    
    TraceHistory history = new TraceHistory();
    
	// ********* constr

	public TT2Decoder () 
	{
		trace_year = Calendar.getInstance().get(Calendar.YEAR); // in case we are tracing live
	}
	
	public void LoadDecoderSubclasses ()
	{
		mTT2Decoder_Scan		= new TT2Decoder_Scan(this);
		mTT2Decoder_Layer1		= new TT2Decoder_Layer1(this);
		mTT2Decoder_LayerMsg	= new TT2Decoder_LayerMsg(this);
		mTT2Decoder_Rest 		= new TT2Decoder_Rest(this);
	}
    
    int getTraceYear ()
    {
    	return trace_year; // year not available from trace header (only month+day+time), so assume current year. 
    }
}
