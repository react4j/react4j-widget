package react4j.widget;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;
import java.util.Objects;
import javax.annotation.Nonnull;
import jsinterop.base.Js;
import org.realityforge.braincheck.BrainCheckConfig;
import react4j.React;
import react4j.ReactNode;
import react4j.dom.ReactDOM;
import static org.realityforge.braincheck.Guards.apiInvariant;

/**
 * A GWT widget that renders a React4j element.
 */
public class ReactWidget
  extends Widget
{
  /**
   * The GWT Element representation.
   */
  private final Element _element;
  /**
   * The react element to render.
   */
  private final ReactNode _node;

  /**
   * Create the widget.
   *
   * @param node the react element to render.
   */
  public ReactWidget( @Nonnull final ReactNode node )
  {
    _element = Document.get().createDivElement();
    _node = Objects.requireNonNull( node );
    if ( BrainCheckConfig.checkApiInvariants() )
    {
      apiInvariant( () -> React.isValidElement( node ),
                    () -> "A ReactNode that is not a valid element has been incorrectly passed to ReactWidget constructor" );
    }
    setElement( _element );
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void onAttach()
  {
    super.onAttach();
    ReactDOM.render( _node, Js.uncheckedCast( _element ) );

  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void onDetach()
  {
    ReactDOM.unmountComponentAtNode( Js.uncheckedCast( _element ) );
    super.onDetach();
  }
}
